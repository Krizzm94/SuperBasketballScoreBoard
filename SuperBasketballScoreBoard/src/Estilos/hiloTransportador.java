package Estilos;

import gui.Informacion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.Principal;

//import sun.awt.windows.ThemeReader;

public class hiloTransportador extends Thread {
 
 Informacion p;
 boolean sw=true;
 int y=800;
 
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
 
 public void run(){
  while(true){
   if(sw){
    p.getTxtInfo().setLocation(20, y);
    if(y>-100){
     y-=5;
    }else{
     y=500;
    }
    try {
     Thread.sleep(100);
    } catch (InterruptedException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }
    p.repaint();
   }
  }
 }
}