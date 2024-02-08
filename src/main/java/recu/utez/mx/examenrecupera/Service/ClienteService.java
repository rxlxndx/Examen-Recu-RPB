package recu.utez.mx.examenrecupera.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import recu.utez.mx.examenrecupera.Model.Cliente;
import recu.utez.mx.examenrecupera.Model.ClienteRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obtenerTodosClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente actualizarCliente(Long id, Cliente nuevoCliente) {
        if (clienteRepository.existsById(id)) {
            nuevoCliente.setId(id);
            return clienteRepository.save(nuevoCliente);
        } else {
            throw new NoSuchElementException("Cliente no encontrado");
        }
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
