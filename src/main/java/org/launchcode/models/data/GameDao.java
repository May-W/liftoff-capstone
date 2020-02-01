package org.launchcode.models.data;

import org.launchcode.models.Console;
import org.launchcode.models.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GameDao extends CrudRepository<Game, Integer> {

}
