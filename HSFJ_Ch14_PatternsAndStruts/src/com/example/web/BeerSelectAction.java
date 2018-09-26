package com.example.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.example.model.BeerExpert;

/*
 * Action对象。
 * Action对象实际是一个分派器。它由ActionServlet调用。
 * ActionServlet会调用Action对象的execute()方法。
 */
public class BeerSelectAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		// 把表单转换为应用特定的表单
		BeerSelectForm myForm = (BeerSelectForm) form;
		// 处理业务逻辑
		BeerExpert be = new BeerExpert();
		List<String> result = be.getBrands(myForm.getColor());
		// 将数据存储在请求作用域并转发到结果视图
		request.setAttribute("styles", result);
		return mapping.findForward("show_result");
		
	}
}
