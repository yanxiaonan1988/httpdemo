package http;

/**
 * Created by yanxiaonan on 17/7/5.
 */
public class HttpHandler {
    private HttpRequest request;
    private HttpResponse response;

    public HttpHandler(){
        request = new HttpRequest();
        response = new HttpResponse(request);
    }

    public void buildFirstLine(String line){
        String[] tokens = line.split(" ");
        request.setMethod(tokens[0]);
        request.setPath(tokens[1]);
        String[] tokens2 = tokens[2].split("/");
        request.setProtocol(tokens2[0].toLowerCase());
        request.setVersion(tokens2[1]);
    }

    public void buildHeader(String line){
        String[] headerPair = this.breakHeader(line);
        request.addHeader(headerPair[0], headerPair[1]);
    }


    private String[] breakHeader(String headerString){
        int i = headerString.indexOf(": ");
        return new String[]{
                headerString.substring(0, i),
                headerString.substring(i+2, headerString.length())};
    }

    public String handle(){
        response.sendHtmlFile();

        return response.buildResponse();
    }

}
