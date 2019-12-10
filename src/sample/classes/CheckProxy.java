package sample.classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;

public class CheckProxy extends Thread{

    private Proxys proxys;

    public CheckProxy(Proxys proxys){
        this.proxys = proxys;
    }

    private void FindProxy() throws IOException {
        String urlProxy = "http://spys.me/proxy.txt";
//        String urlProxy = "https://awmproxy.com/freeproxy_4bcbdc48b752341.txt?";
        String result = null;
        URL url = new URL(urlProxy);
        InputStream inputStream = null;
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        if(connection.getResponseCode()!=401) {
            inputStream = connection.getInputStream();
            result = convertToString(inputStream);
            getProxy(result);
            inputStream.close();
        }
    }

    private void getProxy(String strProxy) throws IOException {
        String ip = null;
        int port = 0;
        int count;
        for (String str:strProxy.split("[\n]")) {
            count=0;
            for (String strNew:str.split("[:]")) {
                if(count==0){
                    ip = strNew;
                } else if(count==1){
                    port = Integer.parseInt(strNew);
                }
                count++;
            }
            URL url = new URL("https://vk.com");
            Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(ip, port));
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection(proxy);
            httpURLConnection.setRequestMethod("GET");
            try {
                httpURLConnection.connect();
                if(httpURLConnection.getResponseCode()==200){
                    proxys.add(new ProxyHTTP(ip, port));
                }
            } catch (IOException e){
                continue;
            }
        }
    }

    private String convertToString(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            if(count>8&&count<310) {
                for (String retval:line.split("[ ]")) {
                    line = retval;
                    break;
                }
                stringBuilder.append(line).append("\n");
            }
            count++;
        }
        inputStream.close();

        return stringBuilder.toString();
    }

    @Override
    public void run() {
        try {
            FindProxy();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.run();
    }
}
