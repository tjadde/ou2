/**
 * The Class that runs everything
 * c15aem
 * alek0013
 * Alexander Ekström
 * Version 1.1
 * Copyright
 */
public class RadioInfo {
    public static void main( String[] args ) {


       /* SwingUtilities.invokeLater(() -> {
            RadioInfoGui gui=new RadioInfoGui( "RadioInfo" );
            gui.show();

        });
        */

       ChannelFinder ChannelFinder = new ChannelFinder();
       ChannelFinder.findChannels();
       ChannelFinder.findSchedule();
        System.out.println("Klar");

    }
}