package com.google.gwt.query.client.css;

import com.google.gwt.dom.client.Style;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.GWT;

/**
 * This property affects the vertical positioning inside a line box of the boxes
 * generated by an inline-level element.
 */
public class BackgroundAttachment
    implements CssProperty<BackgroundAttachment.AttachValue> {

  public BackgroundAttachment() {
    CSS.FIXED = AttachValue.create("fixed");
    CSS.SCROLL = AttachValue.create("scroll");
  }

  public static void init() {
    CSS.BACKGROUND_ATTACHMENT = new BackgroundAttachment();
  }

  public void set(Style s, AttachValue value) {
    s.setProperty("backgroundAttachment", value.value());
  }

  public String get(Style s) {
    return s.getProperty("backgroundAttachment");
  }

  final static public class AttachValue extends JavaScriptObject {

    protected AttachValue() {
    }

    protected static AttachValue create(String val) {
      return GWT.isScript() ? createWeb(val) : createHosted(val);
    }

    public String value() {
      return GWT.isScript() ? valueWeb() : valueHosted();
    }

    private static native AttachValue createWeb(String val) /*-{
      return val;
    }-*/;

    private static native AttachValue createHosted(String val) /*-{
      return [val];
    }-*/;

    private native String valueWeb() /*-{
       return this;
    }-*/;

    private native String valueHosted() /*-{
       return this[0];
    }-*/;
  }
}