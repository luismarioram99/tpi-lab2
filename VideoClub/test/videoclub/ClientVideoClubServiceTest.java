/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;

import junit.framework.TestCase;
import org.easymock.EasyMock;

/**
 *
 * @author jcsv
 */
public class ClientVideoClubServiceTest extends TestCase{
    private IVideoClubService remoteVideoClubServiceMock;
    private IVideo Video28Mock;
    
    protected void setUp() throws Exception{
        super.setUp();
        Video28Mock = EasyMock.createMock(IVideo.class);
        remoteVideoClubServiceMock = EasyMock.createMock(IVideoClubService.class);
    }
    
    public void testClientVideoClubService(){
        try{
            ClientVideoClubService c = new ClientVideoClubService(null);
            fail("Expected IllegalArgumentException");
        }catch(IllegalArgumentException e){
            //expected
        }
        ClientVideoClubService c= new ClientVideoClubService(remoteVideoClubServiceMock);
        
    }
    
    public void testGetVideo() throws Exception{
        EasyMock.expect(remoteVideoClubServiceMock.getVideo(28)).andReturn(Video28Mock);
        EasyMock.replay(remoteVideoClubServiceMock);
        
        IVideoClubService clientVideoClubService = new ClientVideoClubService(remoteVideoClubServiceMock);
        IVideo result = clientVideoClubService.getVideo(28);
        assertEquals(Video28Mock, result);
        
        EasyMock.verify(remoteVideoClubServiceMock);
    }
}

