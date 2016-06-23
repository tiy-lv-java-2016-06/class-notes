import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jeff on 6/23/16.
 */
public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck(){

    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card dealCard(){
        return cards.remove(0);
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public static Deck createStandardDeck(){
        Deck deck = new Deck();

        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                deck.addCard(new Card(suit, rank));
            }
        }
        return deck;
    }

    public static Deck createBridgeDeck(){
        Deck deck = new Deck();

        Rank[] ranks = {Rank.ACE, Rank.JACK, Rank.KING, Rank.QUEEN, Rank.TEN};

        for(Suit suit : Suit.values()){
            for(Rank rank : ranks){
                deck.addCard(new Card(suit, rank));
            }
        }
        return deck;
    }
}
