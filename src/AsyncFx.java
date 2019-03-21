import org.apache.xmlrpc.AsyncCallback;
import org.apache.xmlrpc.XmlRpcClient;

import java.net.URL;
import java.util.Vector;

public class AsyncFx implements AsyncCallback {
    XmlRpcClient srv;
    public AsyncFx(XmlRpcClient sr) {
        this.srv=sr;
    }

    @Override
    public void handleResult(Object o, URL url, String s) {
        System.out.println("For url: "+url);
        Vector<Object> params1 = new Vector<Object>();
        try {
            if( ((Boolean)o).booleanValue() ){
                System.out.println("Operation successful");
                System.out.println(this.srv.execute("BankingServer.getBudget", params1));
            } else {
                System.out.println("Operation unsuccessful, you cannot afford the operation");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void handleError(Exception e, URL u, String method){
        System.out.println("For url: "+u);
        System.out.println("ERROR");
        e.printStackTrace();
    }
}
