package au.com.ericliu.spring_helloworld.landom.data.repository;

import com.frankmoley.landom.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ericliu on 28/6/17.
 */

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    Room findByNumber(String number);
}
