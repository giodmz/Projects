package entities;

public class Candidate {

    private String name;
    private Integer vows;

    public Candidate(String name, Integer vows) {
        this.name = name;
        this.vows = vows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVows() {
        return vows;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((vows == null) ? 0 : vows.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Candidate other = (Candidate) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (vows == null) {
            if (other.vows != null)
                return false;
        } else if (!vows.equals(other.vows))
            return false;
        return true;
    }

    

}
