package demo.oop;

import java.util.Arrays;

/**
 * ʵ���˿�����Card
 * 1 ����54���˿���, 
 * 2 ϴ��
 * 3 ���Ƶ�3��Player��
 *   Player����: String name, Card[] cards = {};
 *   ��ÿ�ν�����ʱ����Ҫ��չcards����
 * 4 ʵ�ֳ�ȡ5���Ƶ��㷨
 */
public class Card {
	private int suit;//��ɫ
	private int rank;//����
	//��ɫ
	public static final int DIAMOND=0;
	public static final int CLUB=1;
	public static final int HEART=2;
	public static final int SPADE=3;
	public static final int JOKER=4;
	//����
	public static final int THREE=0;
	public static final int FOUR=1;
	public static final int FIVE=2;
	public static final int SIX=3;
	public static final int SEVEN=4;
	public static final int EIGHT=5;
	public static final int NINE=6;
	public static final int TEN=7;
	public static final int JACK=8;
	public static final int QUEEN=9;
	public static final int KING=10;
	public static final int ACE=11;
	public static final int DEUCE=12;
	public static final int BLACK=13;
	public static final int COLOR=14;
	public Card(){}
	public Card(int suit,int rank){
		setSuit(suit);
		setRank(rank);
	}
	public void setSuit(int suit){
		if(suit<DIAMOND||suit>JOKER){
			throw new RuntimeException("��ɫ������Χ!");
		}
		this.suit = suit;
	}
	public void setRank(int rank){
		if(rank<THREE||rank>COLOR){
			throw new RuntimeException("����������Χ!");
		}
		this.rank = rank;
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
	private static final String[] SUIT_NAMES = {"����","÷��","����","����",""};
	private static final String[] RANK_NAMES = {"3","4","5","6","7","8","9","10","J","Q","K","A","2","С��","����"};
	@Override
	public String toString(){
		return SUIT_NAMES[suit]+RANK_NAMES[rank];
	}
	@Override
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}
		if(obj==this){
			return true;
		}
		if(obj instanceof Card){
			Card other = (Card)obj;
			return this.rank==other.rank&&this.suit==other.suit;
		}
		return false;
	}
	@Override 
	public int hashCode(){
		return suit*1000+rank;
	}
}
class Player{
	private int id;
	private String name;
	private Card[] cards = new Card[0];
	public Player(){}
	public Player(int id,String name){
		setId(id);
		setName(name);
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void add(Card card){
		cards = Arrays.copyOf(cards, cards.length+1);
		cards[cards.length-1] = card;
	}
	public void setCards(Card[] cards){
		this.cards = cards;
	}
	public Card[] getCards(){
		return cards;
	}
	@Override
	public String toString(){
		return id+" "+name+" "+Arrays.toString(cards);
	}
	@Override
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}
		if(obj==this){
			return true;
		}
		if(obj instanceof Player){
			Player other = (Player)obj;
			return this.id==other.id;
		}
		return false;
	}
	@Override
	public int hashCode(){
		return id;
	}
}