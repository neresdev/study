import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
        String username = "seu_usuario";
        String password = "sua_senha";

        String nome = "John Doe";
        int idade = 30;
        String email = "johndoe@example.com";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO tabela_exemplo (nome, idade, email) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, nome);
            statement.setInt(2, idade);
            statement.setString(3, email);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Registro inserido com sucesso!");
            } else {
                System.out.println("Nenhum registro inserido.");
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar o INSERT: " + e.getMessage());
        }
    }
}
