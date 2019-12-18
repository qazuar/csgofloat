package main.java.enums;

public enum ClientAuth {

    ANY("", "");

    private String username, password;

    ClientAuth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public static ClientAuth get(String value) {
        for (ClientAuth p : values()) {
            if (p.getUsername().equals(value) || p.getPassword().equals(value)) {
                return p;
            }
        }
        return null;
    }

    public static String[] getClients() {
        String[] clients = new String[values().length];
        int i = 0;

        for (ClientAuth client : values()) {
            clients[i] = client.getUsername();
            i++;
        }

        return clients;
    }
}
