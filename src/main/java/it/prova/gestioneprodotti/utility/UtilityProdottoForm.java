package it.prova.gestioneprodotti.utility;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestioneprodotti.model.Prodotto;

public class UtilityProdottoForm {

	public static Prodotto createProdottoFromParams(String nomeInputParam, String descrizioneInputParam,
			String marcaInputParam, String prezzoInputStringParam, String disponibileInputStringParam,
			String dataCreazioneProdottoStringParam) {

		Prodotto result = new Prodotto(nomeInputParam, descrizioneInputParam, marcaInputParam);

		if (NumberUtils.isCreatable(prezzoInputStringParam)) {
			result.setPrezzo(Integer.parseInt(prezzoInputStringParam));
		}
		result.setDataCreazioneProdotto(parseDataCreazioneProdottoFromString(dataCreazioneProdottoStringParam));
		result.setDisponibile(parseBooleanFromString(disponibileInputStringParam));
		return result;
	}

	public static Prodotto createProdottoFromParamsWithId(String idInputParam, String nomeInputParam,
			String descrizioneInputParam, String marcaInputParam, String prezzoInputStringParam,
			String disponibileInputStringParam, String dataCreazioneProdottoStringParam) {

		Prodotto result = new Prodotto(nomeInputParam, descrizioneInputParam, marcaInputParam);
		if (NumberUtils.isCreatable(prezzoInputStringParam)) {
			result.setPrezzo(Integer.parseInt(prezzoInputStringParam));
		}
		if (NumberUtils.isCreatable(idInputParam)) {
			result.setId(Long.parseLong(idInputParam));
		}
		result.setDataCreazioneProdotto(parseDataCreazioneProdottoFromString(dataCreazioneProdottoStringParam));
		result.setDisponibile(parseBooleanFromString(disponibileInputStringParam));
		return result;

	}

	public static boolean validateProdottoBean(Prodotto prodottoToBeValidated) {
		if (StringUtils.isBlank(prodottoToBeValidated.getNome())
				|| StringUtils.isBlank(prodottoToBeValidated.getDescrizione())
				|| StringUtils.isBlank(prodottoToBeValidated.getMarca()) || prodottoToBeValidated.getPrezzo() == null
				|| prodottoToBeValidated.getPrezzo() < 1 || prodottoToBeValidated.getDataCreazioneProdotto() == null) {
			return false;
		}
		return true;
	}

	public static boolean parseBooleanFromString(String booleanString) {
		if (booleanString == null) {
			throw new IllegalArgumentException("La stringa booleana non può essere nulla");
		}

		// Confronta la stringa ignorando maiuscole e minuscole
		if (booleanString.equalsIgnoreCase("true")) {
			return true;
		} else if (booleanString.equalsIgnoreCase("false")) {
			return false;
		} else {
			throw new IllegalArgumentException("Stringa booleana non valida: " + booleanString);
		}
	}

	public static LocalDate parseDataCreazioneProdottoFromString(String dataCreazioneProdottoStringParam) {
		if (StringUtils.isBlank(dataCreazioneProdottoStringParam))
			return null;

		try {
			return LocalDate.parse(dataCreazioneProdottoStringParam);
		} catch (DateTimeParseException e) {
			return null;
		}
	}

}
