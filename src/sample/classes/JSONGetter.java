package sample.classes;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class JSONGetter extends Thread {

    private String response = null;
    private Proxys proxys;

    public JSONGetter(){

    }

    public JSONGetter(String response, Proxys proxys){
        this.response = response;
        this.proxys = proxys;
    }

    public String jsonIn;

    private void ConnectAndGetData() throws IOException {
        jsonIn = "";
        InputStream in = null;
        int count = 0;
        boolean isConnect = false;
        URL url = new URL(response);
        while (!isConnect) {
            if (!proxys.getListProxyHTTP().isEmpty()) {
                for (ProxyHTTP proxyHTTP:proxys.getListProxyHTTP()) {
                    try {
                        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHTTP.getIp(), proxyHTTP.getPort()));
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
                        connection.setRequestMethod("GET");
                        connection.connect();
                        if (connection.getResponseCode() == 200) {
                            in = connection.getInputStream();
                            jsonIn = convertStreamToString(in);
                            in.close();
                            isConnect = true;
                            break;
                        } else {
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.setTitle("Ошибка соединения");
                            alert.setHeaderText("Соединение");
                            alert.setContentText("Проверьте ваше интернет-соединение");
                            alert.showAndWait();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private String convertStreamToString(InputStream stream) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        stream.close();

        return sb.toString();
    }

    @Override
    public void run(){
        try {
            ConnectAndGetData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.run();
    }

}
