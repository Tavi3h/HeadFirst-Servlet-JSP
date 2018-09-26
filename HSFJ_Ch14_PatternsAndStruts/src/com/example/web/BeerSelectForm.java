package com.example.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/*
 * Form Bean，表单bean
 */
// Form Bean必须扩展ActionForm
public class BeerSelectForm extends ActionForm {
	
	private static final long serialVersionUID = -8101706689567686603L;
	private String color;

	/*
	 * 通常Form Bean要有所有表单参数的获取方法和设置方法
	 */
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	/*
	 * ActionServlet调用validate()。
	 * Struts提供了ActionErrors来管理验证错误。
	 */
	private static final String VALID_COLORS = "amber,dark,light,brown";
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (VALID_COLORS.indexOf(color) == -1) {
			errors.add("color", new ActionMessage("error.colorField.notValid"));
		}
		return errors;
	}
}
