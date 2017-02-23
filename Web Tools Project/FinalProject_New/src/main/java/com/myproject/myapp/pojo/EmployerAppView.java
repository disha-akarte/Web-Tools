package com.myproject.myapp.pojo;

public class EmployerAppView {

		String jobTitle;
		int appID;
		String name;
		String status;
		long candidateID;
		
		
		
		public long getCandidateID() {
			return candidateID;
		}
		public void setCandidateID(long candidateID) {
			this.candidateID = candidateID;
		}
		public String getJobTitle() {
			return jobTitle;
		}
		public void setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
		}
		public int getAppID() {
			return appID;
		}
		public void setAppID(int appID) {
			this.appID = appID;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		Application app;
		Job job;
		Candidate candidate;
		public Application getApp() {
			return app;
		}
		public void setApp(Application app) {
			this.app = app;
		}
		public Job getJob() {
			return job;
		}
		public void setJob(Job job) {
			this.job = job;
		}
		public Candidate getCandidate() {
			return candidate;
		}
		public void setCandidate(Candidate candidate) {
			this.candidate = candidate;
		}
		
		
}
