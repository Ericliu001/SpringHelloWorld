package au.com.ericliu.spring_helloworld.landom.data.repository;

import au.com.ericliu.spring_helloworld.landom.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{
    Room findByNumber(String number);
}
