package model;

import enums.ClientAuth;
import model.Request;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class Connector {

    private final int CONNECTION_TIMEOUT = 30000;
    private final int READ_TIMEOUT = 60000;

    private String username, password;

    public Connector(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Connector(ClientAuth clientAuth) {
        if (clientAuth != null) {
            this.username = clientAuth.getUsername();
            this.password = clientAuth.getPassword();
        }
    }

    public String post(Request request, String restPath) {
        try {
            long start = System.currentTimeMillis();

            URL url = new URL(request.getServer() + restPath);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

            addAuthorization(httpCon, username, password);

            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("POST");
            httpCon.setRequestProperty("accept-charset", "UTF-8");
            httpCon.setRequestProperty("content-type", "application/xml");
            httpCon.setConnectTimeout(CONNECTION_TIMEOUT);
            httpCon.setReadTimeout(READ_TIMEOUT);

            if (request.getXml() != null) {
                OutputStream os = httpCon.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

                bw.write(request.getXml());
                bw.flush();
                bw.close();
            }

            request.setResponseCode(httpCon.getResponseCode());
            request.setResponseMessage(httpCon.getResponseMessage());

            StringBuilder sb = new StringBuilder();
            InputStream iStream = httpCon.getErrorStream() == null ? httpCon.getInputStream() : httpCon.getErrorStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream, "UTF-8"));
            String brLine = br.readLine();

            while (brLine != null) {
                sb.append(brLine);
                brLine = br.readLine();
            }

            br.close();

            request.setResponseTime(System.currentTimeMillis() - start);
            request.setResponseXml(sb.toString());

            return request.getResponseXml();
        } catch (IOException e) {
            request.setResponseCode(-1);
            System.out.println("IOException: " + e.getMessage());
        }
        return null;
    }

    public String put(Request request, String restPath) {
        try {
            long start = System.currentTimeMillis();

            URL url = new URL(request.getServer() + restPath);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

            addAuthorization(httpCon, username, password);

            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("PUT");
            httpCon.setRequestProperty("accept-charset", "UTF-8");
            httpCon.setRequestProperty("content-type", "application/xml");
            httpCon.setConnectTimeout(CONNECTION_TIMEOUT);
            httpCon.setReadTimeout(READ_TIMEOUT);

            if (request.getXml() != null) {
                OutputStream os = httpCon.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

                bw.write(request.getXml());
                bw.flush();
                bw.close();
            }

            request.setResponseCode(httpCon.getResponseCode());
            request.setResponseMessage(httpCon.getResponseMessage());

            StringBuilder sb = new StringBuilder();
            InputStream iStream = httpCon.getErrorStream() == null ? httpCon.getInputStream() : httpCon.getErrorStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream, "UTF-8"));
            String brLine = br.readLine();

            while (brLine != null) {
                sb.append(brLine);
                brLine = br.readLine();
            }

            br.close();

            request.setResponseTime(System.currentTimeMillis() - start);
            request.setResponseXml(sb.toString());

            return request.getResponseXml();
        } catch (IOException e) {
            request.setResponseCode(-1);
            System.out.println("IOException: " + e.getMessage());
        }
        return null;
    }

    public String get(Request request, String restPath) {
        try {
            long start = System.currentTimeMillis();

            URL url = new URL(request.getServer() + restPath);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

            addAuthorization(httpCon, username, password);

            httpCon.setRequestMethod("GET");
            httpCon.setConnectTimeout(CONNECTION_TIMEOUT);
            httpCon.setReadTimeout(READ_TIMEOUT);

            request.setResponseCode(httpCon.getResponseCode());
            request.setResponseMessage(httpCon.getResponseMessage());
            request.clearStrings();

            StringBuilder sb = new StringBuilder();
            InputStream iStream = httpCon.getErrorStream() == null ? httpCon.getInputStream() : httpCon.getErrorStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream, "UTF-8"));
            String brLine = br.readLine();

            while (brLine != null) {
                sb.append(brLine);
                request.appendString(brLine);
                brLine = br.readLine();
            }

            br.close();

            request.setResponseTime(System.currentTimeMillis() - start);
            request.setResponseXml(sb.toString());

            return request.getResponseXml();
        } catch (IOException e) {
            request.setResponseCode(-1);
            System.out.println("IOException: " + e.getMessage());
        }
        return null;
    }

    public String delete(Request request, String restPath) {
        try {
            long start = System.currentTimeMillis();

            URL url = new URL(request.getServer() + restPath);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

            addAuthorization(httpCon, username, password);

            httpCon.setRequestMethod("DELETE");
            httpCon.setConnectTimeout(CONNECTION_TIMEOUT);
            httpCon.setReadTimeout(READ_TIMEOUT);

            request.setResponseCode(httpCon.getResponseCode());
            request.setResponseMessage(httpCon.getResponseMessage());
            request.clearStrings();

            StringBuilder sb = new StringBuilder();
            InputStream iStream = httpCon.getErrorStream() == null ? httpCon.getInputStream() : httpCon.getErrorStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream, "UTF-8"));
            String brLine = br.readLine();

            while (brLine != null) {
                sb.append(brLine);
                request.appendString(brLine);
                brLine = br.readLine();
            }

            br.close();

            request.setResponseTime(System.currentTimeMillis() - start);
            request.setResponseXml(sb.toString());

            return request.getResponseXml();
        } catch (IOException e) {
            request.setResponseCode(-1);
            System.out.println("IOException: " + e.getMessage());
        }
        return null;
    }

    private void addAuthorization(HttpURLConnection con, String username, String password) {
        if (username != null && password != null) {
            String login = username + ":" + password;
            String auth = "Basic " + new String(Base64.getEncoder().encode(login.getBytes()));
            con.setRequestProperty("Authorization", auth);
        }
    }
}
