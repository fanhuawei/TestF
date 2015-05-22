package cn.com.mobilereal.common.web;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;

public class BigDecimalPropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null || text.trim().length() == 0) {
			setValue(null);
		} else {
			setValue(new BigDecimal(text));
		}
	}
}
