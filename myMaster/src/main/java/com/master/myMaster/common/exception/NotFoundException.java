package com.master.myMaster.common.exception;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.data.util.Pair;

@Getter
public class NotFoundException extends RuntimeException {

  private static final String RESOURCE_NOT_FOUND = "Resource '%s' with [%s] not found";

  private final Error error;

  /**
   * @param keyValueQueries list of queries used to retrieve the resource
   * @param resourceType    resourceType
   */
  public NotFoundException(
      @NonNull List<Pair<String, Object>> keyValueQueries,
      @NonNull Class<?> resourceType,
      Error error) {
    this(
        keyValueQueries.stream().map(Pair::toString).collect(Collectors.joining(", ")),
        resourceType,
        error);
  }

  /**
   * @param keyValueQuery query used to retrieve the resource
   * @param resourceType  resourceType
   */
  public NotFoundException(
      @NonNull Pair<String, Object> keyValueQuery, @NonNull Class<?> resourceType, Error error) {
    this(keyValueQuery.toString(), resourceType, error);
  }

  /**
   * @param keyValueQueries list of queries used to retrieve the resource
   * @param resourceType    resourceType
   */
  public NotFoundException(@NonNull List<Pair<String, Object>> keyValueQueries,
      @NonNull Class<?> resourceType) {
    this(keyValueQueries.stream()
        .map(Pair::toString)
        .collect(Collectors.joining(", ")), resourceType);
  }

  /**
   * @param query        query used to retrieve the resource
   * @param resourceType resourceType
   */
  public NotFoundException(@NonNull String query, @NonNull Class<?> resourceType, Error error) {
    super(String.format(RESOURCE_NOT_FOUND, resourceType.getSimpleName(), query));
    this.error = error;
  }

  /**
   * @param query        query used to retrieve the resource
   * @param resourceType resourceType
   */
  public NotFoundException(@NonNull String query, @NonNull Class<?> resourceType) {
    super(String.format(RESOURCE_NOT_FOUND, resourceType.getSimpleName(), query));
    this.error = Error.RESOURCE_NOT_FOUND;
  }

  /**
   * @param message
   * @param error
   */
  public NotFoundException(@NonNull String message, @NonNull Error error) {
    super(message);
    this.error = error;
  }
}