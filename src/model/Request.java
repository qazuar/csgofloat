package model;

import enums.ClientAuth;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

public class Request {

    public DocumentBuilder documentBuilder;

    private ClientAuth clientAuth;
    private String server;

    private String xml;
    private Integer responseCode;
    private String responseMessage;
    private String responseXml;
    private Long responseTime;

    private List<String> strings = new ArrayList<>();

    public static synchronized Request newRequest() {
        Request request = null;

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            request = new Request();
            request.documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new NullPointerException("Documentbuilder is null");
        }

        return request;
    }

    public Request() { }

    public ClientAuth getClientAuth() {
        return this.clientAuth;
    }

    public void setClientAuth(ClientAuth clientAuth) {
        this.clientAuth = clientAuth;
    }

    public String getServer() {
        return this.server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getXml() {
        return this.xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public void noXml() {
        this.xml = null;
    }

    // Response values
    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseXml() {
        return this.responseXml;
    }

    public void setResponseXml(String responseXml) {
        this.responseXml = responseXml;
    }

    public Long getResponseTime() {
        return this.responseTime;
    }

    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }

    public List<String> getStrings() {
        return this.strings;
    }

    public void clearStrings() {
        this.strings.clear();
    }

    public void appendString(String a) {
        this.strings.add(a);
    }

    public Request clone() {
        Request request = newRequest(); // Read below
        //request.documentBuilder = this.documentBuilder; // A new instance must be created for every clone
        request.setClientAuth(this.clientAuth);
        request.setServer(this.server);

        return request;

    }

}
