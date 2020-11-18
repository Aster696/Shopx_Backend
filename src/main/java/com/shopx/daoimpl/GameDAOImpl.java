package com.shopx.daoimpl;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopx.dao.GameDAO;
import com.shopx.model.Game;

@Repository(value = "gameDAO")
@Transactional
public class GameDAOImpl implements GameDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addGame(Game game) {
		try {
			sessionFactory.getCurrentSession().save(game);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean updateGame(Game game) {
		try {
			sessionFactory.getCurrentSession().update(game);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean deleteGame(int id) {
		try {
			Game game = new Game();
			game.setId(id);
			sessionFactory.getCurrentSession().delete(game);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public List<Game> displayGames() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from com.shopx.model.Game").getResultList();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public Game displayGameById(int id) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from com.shopx.model.Game where id= : id");
			query.setParameter("id", id);
			return (Game)query.getResultList().get(0);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public Game displayGameByName(String game_name) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from com.shopx.model.Game where game_name= : game_name");
			query.setParameter("game_name", game_name);
			return (Game)query.getResultList().get(0);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public List<Game> search(String game_name) {
		Query query=sessionFactory.getCurrentSession().createQuery("from com.shopx.model.Game where game_name like :bn");
		return query.setParameter("bn", "%"+game_name+"%").getResultList();
	}

	public List<Game> displayHighToLow() {
		return sessionFactory.getCurrentSession().createQuery("from com.shopx.model.Game order by price desc").getResultList();
	}

	public List<Game> displayLowToHigh() {
		return sessionFactory.getCurrentSession().createQuery("from com.shopx.model.Game order by price asc").getResultList();
	}

	public boolean advertiseGame(Game game) {
		try {
			sessionFactory.getCurrentSession().save(game);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public List<String> displayImage(String game_name) {
		List<String> images = new ArrayList();
		try {
			String path = "C:\\Users\\Aster\\eclipse-workspace\\Shopx_Frontend\\src\\main\\webapp\\WEB-INF\\images\\";
			Path p = Paths.get(path+game_name);
			DirectoryStream<Path> files = Files.newDirectoryStream(p,"*.*");
			
			for(Path file:files) {
				images.add(file.getFileName().toString());
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return images;
	}

	

}
