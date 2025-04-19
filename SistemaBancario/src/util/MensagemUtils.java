/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javax.swing.*;

/**
 *
 * @author Pedro
 */
public class MensagemUtils {
    
    public static void mensagem(java.awt.Component parent, String mensagem, String titulo, int tipo) {
        JOptionPane.showMessageDialog(parent, mensagem, titulo, tipo);
    }
    
}
