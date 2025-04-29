package com.avion.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.avion.model.Avion;
import com.avion.util.AvionUtil;

public class AvionDAO {
	
	//INSERTAR:
	
		public void insertAvion(Avion av) {
			Transaction transaction = null;
			try (Session session = AvionUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				session.persist(av);
				transaction.commit();
			} catch (Exception e) {
				if (transaction!=null) {
					transaction.rollback();
				}
			}
		}

		//UPDATE:
		
		public void updateAvion(Avion av) {
			Transaction transaction = null;
			try (Session session = AvionUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				session.merge(av);
				transaction.commit();
			} catch (Exception e) {
				if (transaction!=null) {
					transaction.rollback();
				}
			}
		}
		
		//BORRADO:
		
		public void deleteAvion(int id) {
			Transaction transaction = null;
			Avion av = null;
			try (Session session = AvionUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				av = session.get(Avion.class, id);
				session.remove(av);
				transaction.commit();
			} catch (Exception e) {
				if (transaction!=null) {
					transaction.rollback();
				}
			}
		}
		
		//SELECCION SIMPLE:
		
		public Avion selectAvionById(int id) {
			Transaction transaction = null;
			Avion av= null;
			try (Session session = AvionUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				av = session.get(Avion.class, id);
				transaction.commit();
			} catch (Exception e) {
				if(transaction!=null) {
					transaction.rollback();
				}
			}
			return av;
		}
		
		//SELECCION MULTIPLE:
		
		public List<Avion> selectAllAvion() {
			Transaction transaction = null;
			List<Avion> aviones = null;
			Avion av = null;
			try (Session session = AvionUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				aviones=session.createQuery("from Avion", Avion.class).getResultList();
				transaction.commit();
			} catch (Exception e) {
				if(transaction!=null) {
					transaction.rollback();
				}
			}
			return aviones;
		}

}
