package bahti.gui;
import java.util.ArrayList;

public class HackAttackMain extends Questions
{
    
    public static ArrayList<Questions> ques = new ArrayList<Questions>();
        
    
    public HackAttackMain()
    {
        //Ans: A,D,C,B,A -> 0,3,2,1,0
        String q1="When a source is moving away from \nyou, the doppler effect cause the light \nto:";//G
        String q2="A bright star is moving toward Earth. \nIf you were to look at the spectrum of \nthat star, what would it look like?";//G
        String q3="You observe a distant star with a planet, \nand the light from the star is blueshifted at the \ntime of your observations. Which way is the \nplanet moving at that moment?";
        String q4="If an extrasolar planet takes one year \nto orbit around the center of mass, \nthe star will take:";//G
        String q5="Which of the following will increase \nthe doppler shift of a star?";
        
        String[] a1= {"shift toward longer \nwavelengths", "Become bluer","change in velocity","both A and C"};//G
        String[] a2= {"Absorption spectrum \nthat is redshifted \nrelative to a stationary \nstar", "An emission spectrum \nthat is redshifted \nrelative to a \nstationary star","A continuous spectrum \nthat is blueshifted \nrelative to a stationary \nstar","An absorption \nspectrum that is \nblueshifted relative to \na stationary star"};//G
        String[] a3= {"Across your line of sight","toward you","Away from you","not enough information"};
        String[] a4= {"less that one year","exactly one year","more than one year","cannot tell"};//G
        String[] a5= {"increase the mass of \nthe planet","increase the mass of \nthe star","move the planet farther \nfrom the star","two of the above"};
       
        //Astronomy
        ques.add(new Questions(q1,a1,0));
        //ques.add(new Questions(q2,a2,3));
        ques.add(new Questions(q3,a3,2));
        ques.add(new Questions(q4,a4,1));
        ques.add(new Questions(q5,a5,0));
        
        //Ans: B,C,B,D,A ->1,2,1,3,0
        String q6="English officials tried to \"establish\" \nthe Church of England in as many \ncolonies as possible because";//G
        String q7="In 1775, the ____ churches were \nthe only two established (tax-supported) \nchurches in colonial America.";//G
        String q8="As the Revolution approached, \nPresbyterian and Congregational \nministers in general";
        String q9="By the early eighteenth century, \nreligion in colonial America was";//G
        String q10="The \"new light\" preachers of the Great \nAwakening";//G
        
        String[] a6={"they were concerned \nabout the eternal \nsouls of the colonists.","the church would act \nas a major prop for \nkingly authority.","such an action \nwould restore \nenthusiasm for \nreligion.","the American colonists \nsupported such a \nmove."};
        String[] a7={"Methodist and \nAnglican","Presbyterian and \nCongregational","Congregational and \nAnglican","Quaker and Catholic"};
        String[] a8={"remained neutral.","supported the \nRevolutionary cause.","sided with the Anglican \nclergymen.","opposed the idea of \nrevolution."};
        String[] a9={"stronger than at any \nprevious time.","holding steadfastly to \nthe belief that spiritual \nconversion was \nessential for church \nmembership.","moving away from \nclerical intellectualism.","less fervid than when \nthe colonies were \nestablished."};
        String[] a10={"delivered intensely \nemotional sermons.","rarely addressed \nthemselves to the \nmatter of individual \nsalvation.","reinforced the \nestablished churches.","were ultimately \nunsuccessful in \narousing the religious \nenthusiasm of colonial \nAmericans."};
        
        //History
        ques.add(new Questions(q6,a6,1));
        ques.add(new Questions(q7,a7,2));
        ques.add(new Questions(q8,a8,1));
        ques.add(new Questions(q9,a9,3));
        ques.add(new Questions(q10,a10,0));
        
    }
}