package ru.study.java.andrey;

//public class ClientTester2 {
//    public static void main(String[] args) {
//        Socket socket = null;
//        Scanner scanner = new Scanner(System.in);
//        try {
//            socket = new Socket(ClientConfig.getServerIP(), ClientConfig.getPort());
//            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
//            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
//            while (true) {
////                outputStream.writeUTF(scanner.nextLine());
////                outputStream.flush();
//                Object message = inputStream.readObject();
//                System.out.println(message);
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}
