package Estilos;

import gui.Informacion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.Principal;

/**

 * Esta clase permite generar el movimiento del texto de la ventana informacion  

 * @author: Melissa Gutierrez, Cristian Medina, Wolfran Pinzon 
 
 */

public class hiloTransportador extends Thread {
 
 Informacion p;
 boolean sw=true;
 int y=1200;
 /**Se inicializan y se asigan las variables 
 */
 public hiloTransportador(Informacion prin){
  p=prin;
  p.addMouseListener(new MouseListener(){

   @Override
   public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub
    
   }

   @Override
   public void mouseEntered(MouseEvent e) {
    sw=true;
   }

   @Override
   public void mouseExited(MouseEvent e) {
    sw=true;
   }

   @Override
   public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
    
   }

   @Override
   public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    
   }
   
  });
 }
 
 /**se asigna el tiempo y la ubicacion de donde se empezara el movimiento del texto 
  * */
 public void run(){
  while(true){
   if(sw){
    p.getTxtInfo().setLocation(40, y);
    if(y>-3000){
     y-=60;
    }else{
     y=2000;
    }
    try {
     Thread.sleep(800);
    } catch (InterruptedException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }
  p.repaint();
   }
  }
 }
}