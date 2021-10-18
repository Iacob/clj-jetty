package JettyTemplate;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import java.io.IOException;

public class Main {

    public static void main(String args[]) {

        // Create and configure a ThreadPool.
        QueuedThreadPool threadPool = new QueuedThreadPool();
        threadPool.setName("server");

// Create a Server instance.
        Server server = new Server(threadPool);

// Create a ServerConnector to accept connections from clients.
        ServerConnector connector = new ServerConnector(server);
        //connector.setPort(8081);
        System.out.println(connector.getPort());

// Add the Connector to the Server
        server.addConnector(connector);

// Set a simple Handler to handle requests/responses.
        server.setHandler(new AbstractHandler()
        {
            @Override
            public void handle(String target, Request jettyRequest, HttpServletRequest request, HttpServletResponse response)
            {
                // Mark the request as handled so that it
                // will not be processed by other handlers.
                response.setContentType("text/plain");
                try {
                    response.getWriter().print("aaabbb");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                jettyRequest.setHandled(true);
            }
        });

        // Start the Server so it starts accepting connections from clients.
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
