/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.DAO;

import static com.CSyE6220.TechWorldHustle.DAO.DAO.getSession;
import com.CSyE6220.TechWorldHustle.pojo.CompanyReview;
import com.CSyE6220.TechWorldHustle.pojo.GroupedRatingDTO;
import com.CSyE6220.TechWorldHustle.pojo.IndividualRating;
import com.CSyE6220.TechWorldHustle.pojo.Job;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

/**
 *
 * @author jyoti
 */
public class IndividualRatingDAO extends DAO {
    
        public void addIndividualRating(IndividualRating ir)
	{
		beginTransaction();
		getSession().save(ir);
		commit();
	}
	
	
	public void deleteIndividualRating(IndividualRating ir)
	{
		beginTransaction();
		getSession().delete(ir);
		commit();
	}
        
        
        public List<IndividualRating> getIndividualRatingReviewId(int reviewId)
        {
            beginTransaction();
            String hql = "FROM IndividualRating where ReviewId=:reviewId";
            Query query = getSession().createQuery(hql);
            query.setParameter("reviewId", reviewId);
            List result = query.list();
            commit();
            return result;   
        }
    
        public List<IndividualRating> getAverageIndividualRating(String company)
        {
            beginTransaction();            
            Criteria criteria = getSession().createCriteria(IndividualRating.class);
            
            criteria.createAlias("review", "r");
            criteria.add(Restrictions.eq("r.company",company));
            ProjectionList projList = Projections.projectionList();
            projList.add(Projections.avg("careerOpportunities"));
            projList.add(Projections.avg("compensationAndBenefits"));
            projList.add(Projections.avg("workLifeBalance"));
            projList.add(Projections.avg("seniorManagement"));
            projList.add(Projections.avg("workCulture"));
            projList.add(Projections.avg("valuesEmployee"));
            projList.add(Projections.avg("percentRecommendToAFriend"));
            projList.add(Projections.avg("businessOutlook"));
            projList.add(Projections.avg("ceoApproval")); 
            projList.add(Projections.avg("overallRating"));
            criteria.setProjection(projList);
            List<Object[]> results = criteria.list();
            IndividualRating average_rating = new IndividualRating();
            
            average_rating.setCareerOpportunities((double)results.get(0)[0]);
            average_rating.setCompensationAndBenefits((double)results.get(0)[1]);
            average_rating.setWorkLifeBalance((double)results.get(0)[2]);
            average_rating.setSeniorManagement((double)results.get(0)[3]);
            average_rating.setWorkCulture((double)results.get(0)[4]);
            average_rating.setValuesEmployee((double)results.get(0)[5]);
            average_rating.setPercentRecommendToAFriend((double)(results.get(0)[6]));
            average_rating.setBusinessOutlook((double)results.get(0)[7]);
            average_rating.setCeoApproval((double)results.get(0)[8]);
            average_rating.setOverallRating((double)results.get(0)[9]);
            List<IndividualRating> ir = new ArrayList<>();
            ir.add(average_rating);
            commit();
            return ir;  
        }
        
         public List<GroupedRatingDTO> getTopCompanyIndividualRating()
         {
                beginTransaction();            
                List<GroupedRatingDTO> results = getSession().createCriteria(IndividualRating.class, "ir")
                        .createAlias("ir.review", "r")
                        .setProjection(Projections.projectionList().add(Projections.groupProperty("r.company"),"company")
                        .add(Projections.avg("ir.overallRating"), "avgOARating"))
                        .addOrder(Order.desc("avgOARating"))
                        .setResultTransformer(Transformers.aliasToBean(GroupedRatingDTO.class))
                        .list();  
                for (GroupedRatingDTO r : results ){System.out.println(r.getCompany()+"--"+r.getAvgOARating());}
                commit();
                return results; 
         }
        
}
