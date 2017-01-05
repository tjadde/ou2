
import java.io.IOException;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Created by c15aem on 2017-01-03.
 */
public class ChannelFinder {
    public static final String CHANNEL = "channel";
    public static final String ID = "id";
    public LinkedList ll = new LinkedList();
    public static final String SCHEDULE = "schedule";


    public ChannelFinder(){

    }

    public void findChannels(){
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                .newInstance();

        DocumentBuilder dBuilder = null;
        Document channelDoc = null;
        NodeList channelsList = null;
        Element elementLevel;
        Node nodeLevel = null;
        int nameID = 0;


        try {

            dBuilder = dbFactory.newDocumentBuilder();

            channelDoc = dBuilder.parse("http://api.sr.se/api/v2/channels");
            channelsList = channelDoc.getElementsByTagName(CHANNEL);
            //Every channellin
            for (int channelIndex = 0; channelIndex <
                    channelsList.getLength(); channelIndex++) {

                nodeLevel = channelsList.item(channelIndex);
                //System.out.println("\nCurrent Element :"
                  //      + nNodeLevel.getNodeName());
                if (nodeLevel.getNodeType() == Node.ELEMENT_NODE){
                    elementLevel = (Element) nodeLevel;
                    nameID = Integer.parseInt(elementLevel.getAttribute(ID));
                    //System.out.println(nameID + elementLevel.getAttribute("name"));
                    ll.add(nameID);
                    
                }

            }


        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
    public void findSchedule(){
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                .newInstance();

        DocumentBuilder dBuilder = null;
        Document channelDoc = null;
        NodeList episodeList = null;
        Element elementLevel = null;
        Node nodeLevel = null;
        System.out.println("hej");



        try {

            dBuilder = dbFactory.newDocumentBuilder();
            //for (int i = 0; i < ll.size();i++) {

                channelDoc = dBuilder.parse("http://api.sr.se/api/v2/scheduledepisodes?channelid=164");
                episodeList = channelDoc.getElementsByTagName(SCHEDULE);
                //Every channel
                for (int episodeIndex = 0; episodeIndex <
                        episodeList.getLength(); episodeIndex++) {

                    nodeLevel = episodeList.item(episodeIndex);
                    //System.out.println("\nCurrent Element :"
                    //      + nNodeLevel.getNodeName());
                    if (nodeLevel.getNodeType() == Node.ELEMENT_NODE) {
                        elementLevel = (Element) nodeLevel;
                        for (int p = 0; p < episodeList.getLength(); p++) {
                            System.out.println(elementLevel.getElementsByTagName("title").item(p).getTextContent());
                            //System.out.println(elementLevel.getElementsByTagName("channel").item(0).getTextContent());

                        }
                    }
                    //System.out.println(f);

                }

           //}
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    }

