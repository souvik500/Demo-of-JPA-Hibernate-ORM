package com.hibarnateORM.JPAHibarnatedemo;


import jakarta.persistence.*;

@Entity
public class Card
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement Primary Key
    private int cardNo;

    /**
     * We can not make that field Empty/Null but its not a primary Key
     * @return
     */
    @Column(nullable = false, unique = true)
    private String dob;

    // SQL type Casting from ENUM datatype to Varchar
    @Enumerated(EnumType.STRING)
    private Status cardStatus;

    //Currently join child Table to Parent Table, Here Card is Child and Parent is User
    //and Card to User is One-to-One Relationship But Common Sense is
    // Without User card is not valid so User shall Parent and Card is child (because card depends on User)

    @OneToOne  //this one for current table to parent table relationship
    @JoinColumn  //add primary key of parent table(User) to child table(Card) as Foreign Key and its join based on Primary Key
    User user;

    public Card() {
    }

    public Card(int cardNo, String dob, Status cardStatus) {
        this.cardNo = cardNo;
        this.dob = dob;
        this.cardStatus = cardStatus;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }


    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Status getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(Status cardStatus) {
        this.cardStatus = cardStatus;
    }
}
