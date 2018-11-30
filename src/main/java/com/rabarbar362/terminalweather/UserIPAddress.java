package com.rabarbar362.terminalweather;

import java.net.*;
import java.io.*;

public class UserIPAddress {
    private String IPAddress;

    public UserIPAddress() throws IOException {
        URL getUserIP = new URL("http://checkip.amazonaws.com");
        BufferedReader in = new BufferedReader(new InputStreamReader(getUserIP.openStream()));
        IPAddress = in.readLine();
    }

    public String getIPAddress() {
        return IPAddress;
    }
}
