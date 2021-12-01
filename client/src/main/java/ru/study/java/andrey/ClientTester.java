package ru.study.java.andrey;

//public class ClientTester {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        try (Socket socket = new Socket(ClientConfig.getServerIP(), ClientConfig.getPort());
//             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
//             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {
//            List allMessages = (List) inputStream.readObject();
//            for (Object message : allMessages) {
//                System.out.println(message);
//            }
//            while (true) {
//                outputStream.writeUTF(scanner.nextLine());
//                outputStream.flush();
//                Object message = inputStream.readObject();
//                System.out.println(message);
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}
