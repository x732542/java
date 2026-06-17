package tw.brad.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tw.brad.entity.Member;
import tw.brad.entity.Test;
import tw.brad.utils.HibernateUtil;

public class MemberDao {
	public void addMember(Member member) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();
			session.persist(member);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void delMember(Member member) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();
			session.remove(member);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void updateMember(Member member) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			transaction = session.beginTransaction();
			session.merge(member);
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public Member findById(long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			return session.get(Member.class, id);
		} catch (Exception e) {
		}
		return null;
	}

	public List<Member> findAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			String hql = "FROM Member";
			Query<Member> query = session.createQuery(hql, Member.class);
			return query.getResultList();
		} catch (Exception e) {
		}
		return null;
	}

	public List<Member> findByAccountLike(String key) {
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			String hql = "FROM Member WHERE account LIKE :key";
			Query<Member> query = session.createQuery(hql, Member.class);
			query.setParameter("key", "%" + key + "%");
			return query.getResultList();
		} catch (Exception e) {
		}
		return null;

	}

}