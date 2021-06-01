import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Base64;
import javax.swing.event.*;

/**
 *
 * A Simple Base64 Encoder/Decoder
 *
 * @version 1.0 - 01.06.2021
 * DS_Stift007
 */

public class jCrypt extends JFrame {
  // BEGIN Attributes
  private JTextField tfEncryptText = new JTextField();
  private JButton bEncrypt = new JButton();
  private JTextField tfDecryptText = new JTextField();
  private JButton bDecrypt = new JButton();
  private JTextArea jTextArea1 = new JTextArea("");
    private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  private JLabel lEncodeText = new JLabel();
  private JLabel lDecodeText = new JLabel();
  // End Attributes
  
  public jCrypt() { 
    // Frame-Setup
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 487; 
    int frameHeight = 535;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("jCrypt - Base64 Encryption/Decryption");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // BEGIN Components
    
    tfEncryptText.setBounds(104, 8, 273, 25);
    tfEncryptText.setText("");
    cp.add(tfEncryptText);
    bEncrypt.setBounds(384, 8, 73, 25);
    bEncrypt.setText("Encrypt");
    bEncrypt.setMargin(new Insets(2, 2, 2, 2));
    bEncrypt.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bEncrypt_ActionPerformed(evt);
      }
    });
    cp.add(bEncrypt);
    tfDecryptText.setBounds(104, 48, 273, 25);
    tfDecryptText.setText("");
    cp.add(tfDecryptText);
    bDecrypt.setBounds(384, 48, 73, 25);
    bDecrypt.setText("Decrypt");
    bDecrypt.setMargin(new Insets(2, 2, 2, 2));
    bDecrypt.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bDecrypt_ActionPerformed(evt);
      }
    });
    cp.add(bDecrypt);
    jTextArea1ScrollPane.setBounds(16, 80, 441, 409);
    cp.add(jTextArea1ScrollPane);
    lEncodeText.setBounds(8, 8, 89, 25);
    lEncodeText.setText("Encode Text:");
    cp.add(lEncodeText);
    lDecodeText.setBounds(8, 48, 89, 25);
    lDecodeText.setText("Decode Text:");
    cp.add(lDecodeText);
    // End Components
    
    setVisible(true);
  } // end of public jCrypt
  
  // BEGIN Methods
  
  public static String encode(String str){
    Base64.Encoder encoder= Base64.getEncoder(); // Create a new Encoder
    
    byte[] encoded = encoder.encode(str.getBytes());    // Get a Byte-object fom the Encoded String
    
    return new String(encoded);
  }
  
  public static String decode(String str){
    Base64.Decoder decoder= Base64.getDecoder();  // Create a new Decoder
    
    byte[] decoded = decoder.decode(str.getBytes());   // Get a Byte-object fom the Decoded String
    
    return new String(decoded);
  }
  
  
  public static void main(String[] args) {
    new jCrypt();
  } // end of main
  
  public void bEncrypt_ActionPerformed(ActionEvent evt) {
    jTextArea1.setText(encode(tfEncryptText.getText()));
    
  } // end of bEncrypt_ActionPerformed

  public void bDecrypt_ActionPerformed(ActionEvent evt) {
    jTextArea1.setText(decode(tfDecryptText.getText())); // Put decoded text into jTextArea1
    
  } // end of bDecrypt_ActionPerformed

  // End Methods
} // end of class jCrypt
