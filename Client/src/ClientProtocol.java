import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientProtocol {
    private Socket socket;

    public ClientProtocol(Socket socket) {
        this.socket = socket;
    }

    public void sendHello(Socket socket, byte opCode, int id, String name) {
        try {
            DataOutputStream data_outPut = new DataOutputStream(socket.getOutputStream());
            byte[] buffer = {0, 0};
            data_outPut.writeByte(opCode); // Capçalera, serà un 1, perque es el HELLO
            data_outPut.writeChars(name); // Longitud sense limit //FALLA A PARTIR DE  AQUI Y NO SE PORQUE AUN CREO PORQUE EN EL DATA OTUPUT SE DEBE ENVIAR COMO TOODO EN UNA LISTA O ALGO PERO SOLO PERMITE ESCRIBIR UNA COSA
            //data_outPut.flush();
            data_outPut.write(buffer); // Indica el final de trama
            //data_outPut.flush();
            data_outPut.writeInt(id);

            data_outPut.flush();
            data_outPut.close();
        } catch (IOException e) {
            throw new RuntimeException("I/O Error when creating or sending the output stream. Is the host connected?:\n" + e.getMessage());
        }

    }

    public void recivedHello(Socket socket) {

    }

}