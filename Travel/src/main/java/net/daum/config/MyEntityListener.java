package net.daum.config;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
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
    @PostUpdate
    public void onPostPersistOrUpdate(PlanVO p) {
        String message ="실시간으로 추가된 서울 여행객 "+p.getCities();
        socketHandler2.broadcast(message);
    }
}
