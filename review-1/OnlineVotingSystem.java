import java.util.*;

class DuplicateVoteException extends Exception {
    public DuplicateVoteException(String message) {
        super(message);
    }
}

class Voter {
    private String voterId;
    private String name;
    private boolean Voted;

    public Voter(String voterId, String name) {
        this.voterId = voterId;
        this.name = name;
        this.Voted = false;
    }

    public String getVoterId() { 
        return voterId;
    }

    public String getName() { 
        return name; 
    }
    public boolean Voted() { 
        return Voted;
    
    }

    public void setVoted(boolean Voted) { 
        this.Voted = Voted;
    }
}

class Candidate {
    private String candidateId;
    private String name;

    public Candidate(String candidateId, String name) {
        this.candidateId = candidateId;
        this.name = name;
    }

    public String getCandidateId() { 
        return candidateId; 
    }

    public String getName() { 
        return name; 
    }
}

class Vote {
    private String voterId;
    private String candidateId;
  
    public Vote(String voterId, String candidateId) {
        this.voterId = voterId;
        this.candidateId = candidateId;
    }

    public String getVoterId() { 
        return voterId; 
    }
    public String getCandidateId() { 
        return candidateId; 
    }
}

interface ElectionService {
    void registerVoter(Voter voter);
    void addCandidate(Candidate candidate);
    void castVote(String voterId, String candidateId) throws DuplicateVoteException;
    void declareResults();
}

class ImplementElectionService implements ElectionService{

    private HashMap<String, Voter> voters = new HashMap<>();
    private HashMap<String, Candidate> candidates = new HashMap<>();
    private HashMap<String, Integer> voteCount = new HashMap<>();

    
    public void registerVoter(Voter voter) {
        voters.put(voter.getVoterId(), voter);
    }

    public void addCandidate(Candidate candidate) {
        candidates.put(candidate.getCandidateId(), candidate);
        voteCount.put(candidate.getCandidateId(), 0);
    }

    public void castVote(String voterId, String candidateId) throws DuplicateVoteException {
        Voter voter = voters.get(voterId);
    
        if (voter.Voted()) {
            throw new DuplicateVoteException("Voter " + voter.getName() + " has already voted!");
        }

        if (!candidates.containsKey(candidateId)) {
            System.out.println("Candidate not found!");
            return;
        }

        voter.setVoted(true);
        voteCount.put(candidateId, voteCount.get(candidateId) + 1);
        System.out.println("Vote casted successfully");
    }
    
    public void declareResults() {
        System.out.println("\nElection Results:");
        Candidate winner = null;
        int maxVotes = -1;

        for (Candidate c : candidates.values()) {
            int votes = voteCount.get(c.getCandidateId());
            if (votes > maxVotes) {
                maxVotes = votes;
                winner = c;
            }
        }

        if (winner != null) {
            System.out.println("\n Candidate with most votes " + winner.getName());
        }
    }
}



public class OnlineVotingSystem {
    public static void main(String[] args) {
        ElectionService election = new ImplementElectionService();

        election.registerVoter(new Voter("V1", "Alankrati"));
        election.registerVoter(new Voter("V2", "Ayushi"));
        election.registerVoter(new Voter("V3", "Garvit"));
        election.addCandidate(new Candidate("C1", "Sahil Sir"));
        election.addCandidate(new Candidate("C2", "Shardul Sir"));


        try {
            election.castVote("V1", "C1");
            election.castVote("V2", "C2");
            election.castVote("V3", "C1");
            election.castVote("V1", "C2");
        } 
        catch (DuplicateVoteException e) {
            System.out.println(e.getMessage());
        }

        election.declareResults();
    }
}


