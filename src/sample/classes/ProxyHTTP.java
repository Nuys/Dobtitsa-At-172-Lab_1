package sample.classes;

public class ProxyHTTP {

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    private String ip;
    private int port;

    public ProxyHTTP(){

    }

    public ProxyHTTP(String ip, int port){
        this.ip = ip;
        this.port = port;
    }
}
