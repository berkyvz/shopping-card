package shoppingcart.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test class of the Campaign.
 *
 * @see shoppingcart.model.Campaign
 */
public class CampaignTest {

    /**
     * Tests getter methods of the model.
     */
    @Test
    public void testGetters() {
        int discountRate = 5;
        Category category = new Category("category-1");
        Campaign campaign = new Campaign(discountRate, category);
        assertEquals(campaign.getCategory(), category);
        assertEquals(campaign.getRate(), discountRate);
    }


    /**
     * Tests setter methods of the model.
     */
    @Test
    public void testSetters() {
        int discountRate = 5;
        Category category = new Category("category-1");
        Campaign campaign = new Campaign(0, null);
        campaign.setCategory(category);
        campaign.setRate(discountRate);
        assertEquals(campaign.getCategory(), category);
        assertEquals(campaign.getRate(), discountRate);
    }
}
