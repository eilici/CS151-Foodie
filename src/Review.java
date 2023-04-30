package Foodie;

public class Review {
	private String review;
	private double rating;
	
	public Review(String review, double rating) {
		this.review = review;
		this.rating = rating;
	}
	
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
}
