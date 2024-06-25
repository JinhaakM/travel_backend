package net.daum.config;






import javax.persistence.PostPersist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.daum.vo.PlanVO;

@Component
public class MyEntityListener {

    private static SocketHandler2 socketHandler2;
    
    @Autowired
    public void setSocketHandler2(SocketHandler2 socketHandler2) {
        MyEntityListener.socketHandler2 = socketHandler2;
    }
    

    @PostPersist
    //@PostUpdate
    public void onPostPersistOrUpdate(PlanVO p) {

        String message = "서울 여행객이 추가됩니다.";
        socketHandler2.broadcast(message);
    }
}
