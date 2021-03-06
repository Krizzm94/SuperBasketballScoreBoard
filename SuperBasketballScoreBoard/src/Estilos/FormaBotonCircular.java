package Estilos;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

/**

 * Esta clase permite cambiar la apariencia de los botones de una manera circular  

 * @author: Melissa Gutierrez, Cristian Medina, Wolfran Pinzon 
 
 */

public class FormaBotonCircular extends JButton {

  // Constructor del Bot�n Redondo
  public FormaBotonCircular( String rotulo ) {
    super( rotulo );

    // Igualamos las dimensiones para que el bot�n sea un c�rculo en vez de
    // una elipse
    Dimension tamano = getPreferredSize();
    tamano.width = tamano.height = Math.max( tamano.width,tamano.height );
    setPreferredSize( tamano );

    // Hacemos que el JButton no pinte su fondo, de este modo podremos
    // nosotros hacer que el color de fondo que se salga de la figura sea
    // del mismo color que el fondo de la ventana
    setContentAreaFilled( false );
    }

  // Este es el m�todo que pinta el bot�n en el color correspondiente al estado
  // en que se encuentre, y tambi�n coloca el r�tulo que se haya indicado en el
  // centro del bot�n
  protected void paintComponent( Graphics g ) {
    if( getModel().isArmed() ) {
      // Se puede hacer que la caracter�stica de Pulsado sea una propiedad de
      // esta clase
      g.setColor( Color.lightGray );
      } 
    else {
      g.setColor( getBackground() );
      }
    g.fillOval( 0,0,getSize().width-1,getSize().height-1);

    // Llamando al m�todo de la clase padre, haremos que aparezca el r�tulo y
    // hacemos que el rest�ngulo correspondiente al bot�n sea el que controla
    // el foco
    super.paintComponent( g );
    }

  // Pintamos el borde del bot�n con una l�nea simple
  protected void paintBorder( Graphics g ) {
    g.setColor( getForeground() );
    g.drawOval( 0,0,getSize().width-1,getSize().height-1 );
    }

  // Este es el m�todo que controla la posici�n del rat�n en el momento de
  // pulsar su bot�n. Se sobreescribe para controlar los cambios de tama�o
  // del bot�n
  Shape figura;
  public boolean contains( int x,int y ) {
    // En caso de que el bot�n cambie de tama�o, hay que conseguir una nueva
    // figura que se adapte a ese nuevo tama�o
    if( figura == null || !figura.getBounds().equals(getBounds()) ) {
      figura = new Ellipse2D.Float( 0,0,getWidth(),getHeight() );
      }
    return( figura.contains( x,y ) );
    }
}
