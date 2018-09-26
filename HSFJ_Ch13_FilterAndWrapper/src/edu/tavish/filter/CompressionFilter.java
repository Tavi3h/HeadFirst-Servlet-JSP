package edu.tavish.filter;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.tavish.wrapper.CompressionResponseWrapper;

/*
 * 这个过滤器的核心是用装饰器包装响应对象，
 * 它用一个压缩I/O流包装输出流。
 * 当且亲当客户包含一个Accept-Encoding首部（具体为gzip）时，
 * 才会完成输出流的压缩。
 */
public class CompressionFilter implements Filter {

	private ServletContext ctx;
	private FilterConfig fConfig;
	
	/*
	 * init方法保存配置对象，并保存Servlet上下文对象的一个引用，以便完成日志。
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
		ctx = fConfig.getServletContext();
		ctx.log(fConfig.getFilterName() + " initialized.");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String valid_encodings = request.getHeader("Accept-Encoding");
		/*
		 * 判断客户是否接受GZIP压缩
		 */
		if (valid_encodings.indexOf("gzip") > -1) {
			/*
			 * 如果客户接受GZIP压缩，则用一个压缩包装器包装响应对象。
			 */
			CompressionResponseWrapper wrappedResp = new CompressionResponseWrapper(response);
			wrappedResp.setHeader("Content-Encoding", "gzip");
			chain.doFilter(request, wrappedResp);

			GZIPOutputStream gzos = wrappedResp.getGZIPOutputStream();
			/*
			 * GZIP压缩流必须“结束”，这也会刷新输出GZIP流缓冲区，
			 * 将所有数据发送到原来的响应流。
			 */
			gzos.finish();
			ctx.log(fConfig.getFilterName() + ": finished the request.");
		} else {
			ctx.log(fConfig.getFilterName() + ": no encoding performed.");
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		fConfig = null;
		ctx = null;
	}

}
