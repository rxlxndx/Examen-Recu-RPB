package recu.utez.mx.examenrecupera.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.SecureRandom;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name="Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean activo;


    public void generarPasswordAleatoria() {
        // Definir la cadena de caracteres que se utilizarán para generar la contraseña
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        // Crear un generador de números aleatorios seguro
        SecureRandom random = new SecureRandom();
        // StringBuilder para construir la contraseña
        StringBuilder password = new StringBuilder();
        // Generar cada carácter de la contraseña
        for (int i = 0; i < 8; i++) {
            // Obtener un índice aleatorio dentro de la longitud de la cadena de caracteres
            int index = random.nextInt(caracteres.length());
            // Agregar el carácter correspondiente al índice a la contraseña
            password.append(caracteres.charAt(index));
        }
        // Almacenar la contraseña generada en el objeto actual
        this.password = password.toString();
    }
}
