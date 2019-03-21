import org.apache.xmlrpc.XmlRpcClient;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        XmlRpcClient srv = null;
        try {
            srv = new XmlRpcClient("http://localhost:8090");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
       AsyncFx asy = new AsyncFx(srv);
        try {
            Vector<Double> params = new Vector<Double>();
            params.addElement(10543.0);
            srv.execute("BankingServer.depositMoney",params);
            params.clear();
            Vector<Object> params2 = new Vector<Object>();
            System.out.println(srv.execute("BankingServer.getBudget",params2));
            params.addElement(150.0);
            srv.executeAsync("BankingServer.withdrawMoney",params,asy);

        } catch (Exception exception) {
            System.err.println("XML-RPC client: " +exception);
        }
    }
}
