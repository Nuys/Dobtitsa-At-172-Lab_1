package sample.classes;

import java.util.ArrayList;

public class Proxys {

    public ArrayList<ProxyHTTP> getListProxyHTTP() {
        return listProxyHTTP;
    }

    public void setListProxyHTTP(ArrayList<ProxyHTTP> listProxyHTTP) {
        this.listProxyHTTP = listProxyHTTP;
    }

    private ArrayList<ProxyHTTP> listProxyHTTP;

    public Proxys(){
        this.listProxyHTTP = new ArrayList<>();
    }

    public void add(ProxyHTTP proxyHTTP){
        this.listProxyHTTP.add(proxyHTTP);
    }
}
