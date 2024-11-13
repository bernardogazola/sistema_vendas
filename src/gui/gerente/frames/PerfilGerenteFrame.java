package gui.gerente.frames;

import model.Gerente;

import javax.swing.*;
import java.awt.*;

public class PerfilGerenteFrame extends JFrame {

    public PerfilGerenteFrame(Gerente gerente) {
        setTitle("Perfil do Gerente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel perfilPanel = new JPanel();
        perfilPanel.setLayout(new BoxLayout(perfilPanel, BoxLayout.Y_AXIS));

        perfilPanel.add(new JLabel(gerente.exibirInfo()));
        perfilPanel.add(new JLabel("CPF: " + gerente.getCpf()));
        perfilPanel.add(new JLabel("Telefone: " + gerente.getTelefone()));
        perfilPanel.add(new JLabel("Salário: R$ " + gerente.getSalario()));
        perfilPanel.add(new JLabel("Data de Contratação: " + gerente.getDataContratacao()));

        add(perfilPanel, BorderLayout.CENTER);
    }
}

