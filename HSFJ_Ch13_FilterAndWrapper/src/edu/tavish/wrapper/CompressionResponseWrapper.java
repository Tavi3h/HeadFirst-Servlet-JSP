package edu.tavish.wrapper;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

class GZIPServletOutputStream extends ServletOutputStream {

	GZIPOutputStream internalGzipOS;
	private ServletOutputStream servletOutputStream;

	public GZIPServletOutputStream(ServletOutputStream sos) throws IOException {
		this.internalGzipOS = new GZIPOutputStream(sos);
		servletOutputStream = sos;
	}

	/*
	 * 这个方法把write()调用委托给GZIP压缩流，从而实现压缩装饰，
	 * GZIP压缩流包装了原来的ServletOutputStream（ServletOutputStream则包装
	 * 了返回客户的TCP网络输出流）。
	 */
	@Override
	public void write(int param) throws IOException {
		internalGzipOS.write(param);
	}

	@Override
	public void setWriteListener(WriteListener writeListener) {
		this.servletOutputStream.setWriteListener(writeListener);
	}

	@Override
	public boolean isReady() {
		return this.servletOutputStream.isReady();
	}
}

/*
 * 这个响应包装器装饰了原来的响应对象，
 * 在原Servlet输出流上增加了一个压缩装饰器。
 */
public class CompressionResponseWrapper extends HttpServletResponseWrapper {

	/*
	 * Servlet响应的压缩输出流。
	 */
	private GZIPServletOutputStream servletGzipOS = null;
	/*
	 * 压缩输出流的PrintWriter对象。
	 */
	private PrintWriter pw = null;
	private Object streamUsed = null;

	/*
	 * super构造函数完成装饰器的职责：
	 * 保存所装饰对象的一个引用，在这里被装饰的对象就是HTTP响应对象。
	 */
	public CompressionResponseWrapper(HttpServletResponse response) {
		super(response);
	}

	/*
	 * 过滤器使用这个装饰器方法为压缩过滤器提供一个GZIP输出流的句柄，
	 * 以便过滤器“完成”和刷新输出GZIP流。
	 */
	public GZIPOutputStream getGZIPOutputStream() {
		return this.servletGzipOS.internalGzipOS;
	}

	/*
	 * 允许访问所装饰的Servlet输出流。
	 */
	public ServletOutputStream getOutputStream() throws IOException {
		/*
		 * 仅当Servlet还没有访问打印书写器时，允许Servlet访问Servlet输出流。
		 */
		if ((streamUsed != null) && (streamUsed != pw)) {
			throw new IllegalStateException();
		}
		if (servletGzipOS == null) {
			/*
			 * 用我们的压缩输出流包装原来的Servlet输出流。
			 */
			servletGzipOS = new GZIPServletOutputStream(getResponse().getOutputStream());
			streamUsed = servletGzipOS;
		}
		return servletGzipOS;
	}

	/*
	 * 允许访问所装饰的打印书写器。
	 */
	public PrintWriter getWriter() throws IOException {
		/*
		 * 当且仅当Servlet还没有访问Servlet输出流时，允许Servlet访问打印书写器。
		 */
		if ((streamUsed != null) && (streamUsed != servletGzipOS)) {
			throw new IllegalStateException();
		}
		if (pw == null) {
			/*
			 * 要建立一个打印书写器，必须首先包装Servlet输出流，
			 * 然后把压缩Servlet输出流包装在另外两个输出流装饰器中：
			 * 首先OutputStreamWriter把字符转换为字节，
			 * 再用PrintWriter包装OutputStreamWriter对象。
			 */
			servletGzipOS = new GZIPServletOutputStream(getResponse().getOutputStream());
			OutputStreamWriter osw = new OutputStreamWriter(servletGzipOS, getResponse().getCharacterEncoding());
			pw = new PrintWriter(osw);
			streamUsed = pw;
		}
		return pw;
	}

}
