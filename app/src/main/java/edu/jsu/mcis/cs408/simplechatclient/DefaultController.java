package edu.jsu.mcis.cs408.simplechatclient;

public class DefaultController extends AbstractController {
    public static final String ELEMENT_OUTPUT_PROPERTY = "Output";

    public void changeOutputText(String newText) {
        setModelProperty(ELEMENT_OUTPUT_PROPERTY, newText);
    }

    public void sendGetRequest() {
        invokeModelMethod("sendGetRequest", null);
    }

    public void sendPostRequest(String s) {
        invokeModelMethod("sendPostRequest", s);
    }

    public void sendDeleteRequest() {
        invokeModelMethod("sendDeleteRequest", null);
    }
}